var form;

function makeEditable(ajaxUrl) {
    form = $('#detailsForm');

    $('#add').click(function () {
        form.find(":select").each(function () {
            $(this).val("");
        });
        $('#id').val(0);
        $('#editRow').modal();
    });

    $('.delete').click(function () {
        deleteRow($(this).attr("id"));
    });

    $('.update').click(function () {
        updateRow($(this).attr("id"));
    });

    form.submit(function () {
        save();
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(event, jqXHR, options, jsExc);
    });

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
    init();
}

function updateRow(id) {
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            var elementName = key;
            if (key === 'positions') {
                $.each(value, function (index) {
                    var optValue = value[index].id;
                    $('#positions').attr('size', value.length).append($("<option></option>")
                        .text(optValue));
                });
            }
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}

function enable(id, chkbox) {
    var enabled = chkbox.is(":checked");
    chkbox.parent().parent().css("text-decoration", enabled ? "none" : "line-through");
    $.ajax({
        url: ajaxUrl + id + '/enable',
        type: 'POST',
        data: 'enabled=' + enabled,
        success: function () {
            successNoty(enabled ? 'Enabled' : 'Disabled');
        }
    });
}

function updateByData(data) {
    oTable_datatable.fnClearTable();
    $.each(data, function (key, item) {
        oTable_datatable.fnAddData(item);
    });
    oTable_datatable.fnDraw();
}

function save() {
    var a = $("#roles").on( "change").val();
    var isAdmin;
    if (a === 'Администратор') {
        isAdmin = '&isAdmin=true';
    } else {
        isAdmin = '&isAdmin=false'
    }
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize() + isAdmin,
        success: function (data) {
            $('#editRow').modal('hide');
            updateTable();
            successNoty('Saved');
        }
    });
}

var failedNote;

function closeNote() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNote();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: true
    });
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNote();
    var errorInfo = $.parseJSON(jqXHR.responseText);

    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + "<br>" + errorInfo.cause + "<br>" + errorInfo.detail,
        type: 'error',
        layout: 'bottomRight'
    });
}

function renderDate(date, type, row) {
    if (type == 'display') {
        var dateObject = new Date(date);
        return '<span>' + dateObject.toISOString().substring(0, 10) + '</span>';
    }
    return date;
}

function renderList(date, type, row) {
    var newDate = '';
    $.each(date, function (index) {
        newDate += date[index].id + '\n';
    });
    return newDate;
}

function renderEmail(data, type, row) {
    if (type == 'display') {
        return '<a href="mailto:' + data + '">' + data + '</a>';
    }
    return data;
}

function renderUpdateBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="updateRow(' + row.id + ')">Update</a>';
    }
    return data;
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + row.id + ')">Delete</a>';
    }
    return data;
}

function renderCheckbox(data, type, row) {
    if (type == 'display') {
        return '<input type="checkbox"' + (data ? ' checked ' : ' ') + 'onclick="enable(' + row.id + ',$(this))"/>';
    }
    return data;
}
