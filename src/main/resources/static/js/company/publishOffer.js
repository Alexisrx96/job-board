$(function () {
    $("#publish").submit(function (e) {
        e.preventDefault();

        Swal.showLoading();

        $("#SubmitBtn").prop("disabled", true);

        $.ajax({
            url: '/c/publish-offer',
            data: {
                title: $("#title").val(),
                description: $("#description").val(),
                state: $("#state").val(),
                area: $("#area").val(),
                company: $("#company").val()
            },
            type: "post"
        })
            .done(function (result) {
            console.log(result);
                Swal.close();
                Swal.fire({
                    icon: 'success',
                    title: 'Oferta añadida',
                    text: `La oferta ${$("#title").val()} fue añadida con éxito`
                })
                 $("#title").val("");
                 $("#description").val("");

            }).fail(function (xhr, status, error) {
                Swal.close();

                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Algo salió mal'
                })
            console.log(xhr);
            console.log(status);
            console.log(error);
            }).always(function (e) {
                $("#SubmitBtn").prop("disabled", false);
            });
    });
});