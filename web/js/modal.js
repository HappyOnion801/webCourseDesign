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
        $("<table class='confirm'><tr class='confirm-title'><td colspan='2'>" + this.title + "</td></tr><tr><td class='confirm-ok fellable' id='confirmOK'>" + this.ok + "</td><td class='confirm-no fellable' id='confirmNO'>" + this.no + "</td></tr></table>").appendTo("#modal");
        $("#modal").addClass("confirmPage").click(function (){
            $("#modal").hide();
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

function createAlert(status, content) {
    var modal = {};
    modal.status = status;
    modal.content = content;
    modal.show = function () {
        if(status==="ok"){
            $("<p class='alert-content'>"+modal.content+"</p>").appendTo("#modal");
            $("#modal").addClass("alertPage").addClass("alertOK");
        }else{
            $("<p class='alert-content'>"+modal.content+"</p>").appendTo("#modal");
            $("#modal").addClass("alertPage").addClass("alertNO");
        }
        $('#modal').slideDown(200,function (){
            setTimeout("$('#modal').slideUp(200)",2000);
        });
    }
    return modal;

}