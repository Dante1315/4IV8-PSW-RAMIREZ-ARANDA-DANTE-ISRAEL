function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function calculo(){
    var valor0 = document.formulario.num_chlopcy.value;
    var valor1 = document.formulario.num_dziewczynki.value;
    var valor_a = parseInt(valor0);
    var valor_b = parseInt(valor1);
    var pokolonie = valor_a + valor_b;
    var porcentaje_chlopcy = (valor_a/pokolonie) * 100;
    var porcentaje_dziewczynki = (valor_b/pokolonie) * 100;

    document.formulario.final_chlopcy.value = porcentaje_chlopcy + " %";
    document.formulario.final_dziewczynki.value = porcentaje_dziewczynki + " %";
}

function borrar(){
    document.formulario.num_chlopcy.value = "";
    document.formulario.num_dziewczynki.value = "";
    document.formulario.final_chlopcy.value = "";
    document.formulario.final_dziewczynki.value = "";
}