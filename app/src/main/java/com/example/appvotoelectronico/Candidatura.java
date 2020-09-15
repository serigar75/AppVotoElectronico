package com.example.appvotoelectronico;

public class Candidatura {
        public Integer idCandidatura;
        public String Nombre;
        public String Imagen;
        public String Candidatos;
        public Candidatura (Integer IdCandidatura,
                            String Nombre,
                            String Imagen,
                            String Candidatos)
        {
                this.idCandidatura = idCandidatura;
                this.Nombre = Nombre;
                this.Imagen = Imagen;
                this.Candidatos=Candidatos;
        }
}
