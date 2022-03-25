package co.com.sofka.mentoring35;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Random {
    private Date date;
    @Id
    private String id;

    private Integer numberDices;

//    private Integer orginalList;

    private List<Integer> randomList;

    public  List<Integer> getRandomList() {
        return randomList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumberDices() {
        return numberDices;
    }

    public void setNumberDices(Integer numberDices) {
        this.numberDices = numberDices;
    }

    /*public Integer getOrginalList() {
        return orginalList;
    }

    public void setOrginalList(Integer orginalList) {
        this.orginalList = orginalList;
    }*/

    public void setRandomList(List<Integer> randomList) {
        this.randomList = randomList;
    }

    
}
