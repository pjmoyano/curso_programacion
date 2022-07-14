package tercero.ejercicio3a;

import java.util.Objects;
import java.util.Scanner;

/*
Este es un programa para registar los alumnos para la escuela primaria Carlos Paz del año que viene.
En la escuela vamos registatondo todos los niños que se vienen a anotar.
Se anota el nombre, apellido, y la edad. El niño no puede tener menos de 6 años ni mas de 8 para inscribirse.
Si no cumple con esta condicion se le dice Que no cumple con la edad necaria.
Una vez inscripto se muestra el mensaje - NIÑO REGISTRADO mas la informacion del niño.
Y tenemos un cupo maximo de 5 alumnos, asi que si se llena ese cupo el programa termina con el mensaje "CUPO COMPLETO"
Al finalizar el programa mostrar el mensaje "FIN DEL PROGRAMA"

a) Cuando registramos una nueva persona queremos tambien guardar el genero - 'M' para masculino 'F' para femenino.
Mostrar al final de la ejecucion cuantos NIÑOS y NIÑAS se han registrado
 */
public class Ejercicio3a {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        cargarAlumno();
        //cantidadSegunGenero(genero);


    }





/*
EJEMPLO DE EJECUCION 1:
Desea ingresar un niño: 1 - Si 2 - Salir
1
Ingrese el nombre:
Sabri
Ingrese el apellido:
Rizzo
Ingrese la edad:
7
INGRESE EL SEXO: F
NIÑO/A REGISTRADO/A - Sabri Rizzo de 7 años de edad
Desea ingresar un niño: 1 - Si 2 - Salir
1
Ingrese el nombre:
Pablo
Ingrese el apellido:
Marmol
Ingrese la edad:
10
INGRESE EL SEXO: M
El niño no cumple con la edad necesaria
Desea ingresar un niño: 1 - Si 2 - Salir
1
Ingrese el nombre:
Pablo
Ingrese el apellido:
Marmol
Ingrese la edad:
7
INGRESE EL SEXO: M
NIÑO/A REGISTRADO/A - Pablo Marmol de 7 años de edad
Desea ingresar un niño: 1 - Si 2 - Salir
1
Ingrese el nombre:
Pedro
Ingrese el apellido:
Picapiedra
Ingrese la edad:
7
INGRESE EL SEXO: M
NIÑO/A REGISTRADO/A - Pedro Picapiedra de 7 años de edad
Desea ingresar un niño: 1 - Si 2 - Salir
1
Ingrese el nombre:
Vilma
Ingrese el apellido:
Palma
Ingrese la edad:
INGRESE EL SEXO: F
NIÑO/A REGISTRADO/A - Vilma Palma de 7 años de edad
Desea ingresar un niño: 1 - Si 2 - Salir
1
Ingrese el nombre:
Leon
Ingrese el apellido:
Corazon
Ingrese la edad:
7
INGRESE EL SEXO: F
NIÑO/A REGISTRADO/A - Leon Corazon de 7 años de edad
CUPO COMPLETO
NIÑOS:3 NIÑAS:2
Fin del programa


EJEMPLO DE EJECUCION 2:
Desea ingresar un niño: 1 - Si 2 - Salir
2
Fin del programa
 */


    private static void cargarAlumno() {
        Scanner teclado = new Scanner(System.in);
        Persona[] alumno = new Persona[5];
        int opcion = 0;
        int femenino = 0;
        int masculino = 0;
        do {
            for (int i = 0; i < 5; i++) {
                System.out.println("Desea ingresar un niño: 1 - Si / 2 - Salir");
                opcion = teclado.nextInt();
                if (opcion == 2) {
                    break;
                }
                alumno[i] = new Persona();
                alumno[i].cargarAlumno();
                if (alumno[i].getEdad() > 8 || alumno[i].getEdad() < 6) { //lo dejo asi nada mas para poder verificar despues si es 6 y 8 inclusive o si sólo pueden ir los de siete.
                    System.out.println("El niño no cumple con la edad necesaria");
                    i = i - 1;
                    continue;
                }
                if (Objects.equals(alumno[i].getGenero(), "F")) { //no es robado de internet, esto lo recomendó el programa
                    femenino += 1;
                }
                else if (Objects.equals(alumno[i].getGenero(), "M")) {
                    masculino += 1;
                }
                if (Objects.equals(alumno[i].getGenero(), "f")) { //no es robado de internet, esto lo recomendó el programa
                    femenino += 1;
                }
                else if (Objects.equals(alumno[i].getGenero(), "m")) {
                    masculino += 1;
                }

                alumno[i].mostrarAlumno();
                if (i == 4) {
                    System.out.println("CUPO COMPLETO");
                    opcion = 2;
                    System.out.println("NIÑOS: " + masculino + " NIÑAS: " + femenino);
                }


            }
        } // cierre del do
        while (opcion != 2);
    }

/*
    public static void cantidadSegunGenero(String genero) { //robando tu idea
        int femenino = 0;
        int masculino = 0;
        if (genero == "F") {
            femenino += 1;
        }
        else if (genero == "M") {
            masculino += 1;
        }
        System.out.println("NIÑOS: " + masculino + "NIÑAS: " + femenino);
    }
}
*/

}
