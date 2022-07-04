package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {
    //PK값
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 PK값 정해줌 (Identity)
    private Long id;
    @Column(name = "username")  //column 이름 : username
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
