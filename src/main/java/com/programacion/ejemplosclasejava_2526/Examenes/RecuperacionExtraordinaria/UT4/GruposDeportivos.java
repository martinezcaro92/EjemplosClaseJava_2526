package com.programacion.examenes_2526.RecuperaciónExtraordinaria.UT4;

// ══════════════════════════════════════════
//  GruposDeportivos.java — clase completa
// ══════════════════════════════════════════
public class GruposDeportivos {

    private int     idGrupo;
    private String  nombre;
    private String  nif;
    private Persona presidente;
    private Persona secretario;
    private int     numSocios;
    private float   presupuesto;

    public GruposDeportivos(int idGrupo, String nombre, String nif,
                            Persona presidente, Persona secretario,
                            int numSocios, float presupuesto) {
        this.idGrupo     = idGrupo;
        this.nombre      = nombre;
        this.nif         = nif;
        if (presidente == null)
            throw new IllegalArgumentException("El presidente no puede ser null.");
        this.presidente  = presidente;
        this.secretario  = secretario;
        this.numSocios   = (numSocios   >= 0) ? numSocios   : 0;
        this.presupuesto = (presupuesto >= 0) ? presupuesto : 0;
    }

    public int     getIdGrupo()            { return idGrupo; }
    public void    setIdGrupo(int id)      { this.idGrupo = id; }
    public String  getNombre()             { return nombre; }
    public void    setNombre(String n)     { this.nombre = n; }
    public String  getNif()                { return nif; }
    public void    setNif(String nif)      { this.nif = nif; }
    public Persona getPresidente()         { return presidente; }
    public void    setPresidente(Persona p){ if (p != null) this.presidente = p; }
    public Persona getSecretario()         { return secretario; }
    public void    setSecretario(Persona s){ this.secretario = s; }
    public int     getNumSocios()          { return numSocios; }
    public void    setNumSocios(int n)     { if (n >= 0) this.numSocios = n; }
    public float   getPresupuesto()        { return presupuesto; }
    public void    setPresupuesto(float p) { if (p >= 0) this.presupuesto = p; }

    public float   modificarPresupuesto(float cantidad) {
        if (cantidad >= 0) presupuesto += cantidad;
        return presupuesto;
    }

    public int     modificarSocios(int cantidad) {
        if (cantidad >= 0) numSocios += cantidad;
        return numSocios;
    }

    public boolean modificarPresidente(Persona p) {
        if (p != null) { this.presidente = p; return true; }
        return false;
    }
}
