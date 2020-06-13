$( document ).ready(function() {

    var d = new Date();     
    $("#time").text(d.getFullYear()+"/"+(d.getMonth()+1) +"/" + d.getDate());

    $("#export-btn").click(function () {
        $("#table").excel({
            filename: "新ﾃﾞﾎﾟ変換マスター更新.xls"
        });
    });

    $("#r").click(function () {
    	$("#error").text("");
    	$("#success").text("");
        $('tbody').css('background-color','transparent');
    });

});