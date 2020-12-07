function createAlert(status, content) {
    let modal = {};
    modal.status = status;
    modal.content = content;
    modal.show = function () {
        $("<div id='modal' class='alertPage'><p class='alert-content'>" + modal.content + "</p></div>")
            .css("display","none")
            .appendTo("body");
        if (status === "ok") {
            $(".alertPage").addClass("alertOK");
        } else {
            $(".alertPage").addClass("alertNO");
        }
        $('.alertPage').slideDown(200, function () {
            setTimeout(function () {
                $('.alertPage').slideUp(200, function () {
                    $(".alertPage").remove();
                });
            }, 2000);
        });
    }
    return modal;
}

function createConfirm(title, ok, no) {
    let modal = {};
    modal.title = title;
    modal.ok = ok;
    modal.no = no;
    modal.okEvent = function () {
    };
    modal.noEvent = function () {
    };
    modal.show = function () {
        $("<div id='modal' class='confirmPage'><table class='confirm'><tr class='confirm-title'><td colspan='2'>" + this.title + "</td></tr><tr><td class='confirm-ok fellable' id='confirmOK'>" + this.ok + "</td><td class='confirm-no fellable' id='confirmNO'>" + this.no + "</td></tr></table></div>")
            .appendTo("body")
            .click(function () {
            $(".confirmPage").hide(function () {
                $(".confirmPage").remove();
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
    let modal = {};
    modal.type = type;
    modal.data = data;
    modal.okEvent = function (input,data) {
        return true;
    }
    modal.show = function () {
        let table = $("<div id='inputTable'></div>")
        for (key in modal.type) {
            $(table).append("<p>" + key + "</p>")
                .append("<input type='" + modal.type[key] + "' name='" + key + "'/>");
        }
        let okButton = $("<input id='promptButton' type='button' value='确定'/>").click(function () {
            let input = {};
            $("#inputTable").find("input").each(function () {
                input[$(this).attr('name')] = $(this).val();
            });
            let f = modal.okEvent(input,modal.data);
            console.log(f);
            if (f !== false) {
                $(".promptPage").remove();
            }
        });
        let resetButton = $("<input id='promptReset' type='button' value='重置'/>").click(function (){
            $("#inputTable").find("input").val("");
        });
        let con = $("<form id='promptBody'></form>")
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
                $(".promptPage").remove();
            });
    }
    return modal;
}
