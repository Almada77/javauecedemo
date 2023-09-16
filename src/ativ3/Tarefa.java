package ativ3;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private String fone;
    private String email;

    // Construtor
    public Tarefa(int id, String titulo, String descricao, String fone, String email) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.fone = fone;
        this.email = email;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}