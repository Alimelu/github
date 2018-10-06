$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
$(function() {
    $("#myForm").on('submit',function(e){

        $("#myModal").modal("hide");
        e.preventDefault();

        console.log($(this));
        console.log(JSON.stringify($(this).serializeObject()));
        //submit the form
        $.ajax({
            type: "POST",
            url: '/api/repository/',
            contentType: "application/json",
            data: JSON.stringify($(this).serializeObject()),
            success: function (data) {
                console.log(data);

                // add content from another url
                $("#myModal2 .modal-body").html(`<a href="${data.username}/${data.repositoryName}">${data.username}/${data.repositoryName}</a>`);

                // open the other modal
                $("#myModal2").modal("show");
            }
        });

    });
});