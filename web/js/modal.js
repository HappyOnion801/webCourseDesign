function createAlert(status, content) {
    var modal = {};
    modal.status = status;
    modal.content = content;
    modal.body = $("<div id='modal' class='alertPage'><p class='alert-content'>" + modal.content + "</p></div>").appendTo("body");
    modal.show = function () {
        if (status === "ok") {
            $("#modal").addClass("alertOK");
        } else {
            $("#modal").addClass("alertNO");
        }
        $('#modal').slideDown(200, function () {
            setTimeout(function () {
                $('#modal').slideUp(200, function () {
                    modal.body.remove();
                });
            }, 2000);
        });
    }
    return modal;
}

function createConfirm(title, ok, no) {
    var modal = {};
    modal.title = title;
    modal.ok = ok;
    modal.no = no;
    modal.okEvent = function () {
    };
    modal.noEvent = function () {
    };
    modal.show = function () {
        var content = $("<table class='confirm'><tr class='confirm-title'><td colspan='2'>" + this.title + "</td></tr><tr><td class='confirm-ok fellable' id='confirmOK'>" + this.ok + "</td><td class='confirm-no fellable' id='confirmNO'>" + this.no + "</td></tr></table>").appendTo("#modal");
        $("#modal").addClass("confirmPage").click(function () {
            $("#modal").hide(function () {
                $("#modal").remove();
            });
        }).show();
        $("#confirmOK").click(function () {
            modal.okEvent();
        });
        $("#confirmNO").click(function () {
            modal.noEvent();
        });
    }
    return modal;
}

function createPrompt(type,data) {
    var modal = {};
    modal.type = type;
    modal.data = data;
    modal.okEvent = function (input,data) {
        return true;
    }
    modal.show = function () {
        var table = $("<div id='inputTable'></div>")
        for (key in modal.type) {
            $(table).append("<p>" + key + "</p>")
                .append("<input type='" + modal.type[key] + "' name='" + key + "'/>");
        }
        var okButton = $("<input id='promptButton' type='button' value='确定'/>").click(function () {
            var input = {};
            $("#inputTable").find("input").each(function () {
                input[$(this).attr('name')] = $(this).val();
            });
            modal.okEvent(input,modal.data);
            if (modal.okEvent() !== false) {
                $("#modal").remove();
            }
        });
        var resetButton = $("<input id='promptReset' type='button' value='重置'/>").click(function (){
            $("#inputTable").find("input").val("");
        });
        var con = $("<form id='promptBody'></form>")
            .append(table)
            .append(resetButton)
            .append(okButton)
            .append("<p></p>").click(function () {
                return false;
            });
        $("<div id='modal' class='promptPage'></div>")
            .append(con)
            .appendTo("body")
            .click(function () {
                $("#modal").remove();
            });
    }
    return modal;
}
