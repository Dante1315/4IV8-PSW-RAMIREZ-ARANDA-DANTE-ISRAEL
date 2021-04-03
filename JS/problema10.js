function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function calculo(){
    var valor0 = document.formulario.sueldo.value;
    var valor1 = document.formulario.exp.value;
    var valor_a = parseInt(valor0);
    var valor_b = parseInt(valor1);
    
    if (valor_b < 1) {
        var utilidad = valor_a * 0.05;
    } else {
        if (valor_b >= 1, valor_b < 2) {
            var utilidad = valor_a * 0.07;
        } else {
            if (valor_b >= 2, valor_b < 5){
                var utilidad = valor_a * 0.10;
            } else {
                if (valor_b >= 5, valor_b < 10) {
                    var utilidad = valor_a * 0.15;
                } else {
                    if (valor_b >= 10) {
                        var utilidad = valor_a * 0.20;
                    }
                }
            }
            
        }
    }

    document.formulario.utilidad_final.value = utilidad + " $";
    document.formulario.sueldo_final.value = (utilidad + valor_a) + " $";
}

function borrar(){
    document.formulario.sueldo.value = "";
    document.formulario.exp.value = "";
    document.formulario.utilidad_final.value = "";
    document.formulario.sueldo_final.value = "";
}