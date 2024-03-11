public class E23N1 {
    private String title;
    private String published;
    private int number;
    private Boolean approvedForPublication;
    
    public String getTitle() {
        return this.title;
    }
    public String getPublished() {
        return this.published;
    }
    public int getNumber() {
        return this.number;
    }
    public Boolean getApproved() {
        return this.approvedForPublication;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPublished(String published) {
        this.published = published;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setApproved(Boolean approved) {
        this.approvedForPublication = approved;
    }

public E23N1() {
    this.title = "Untitled";
    this.published = "not set";
    this.number = 0;
    this.approvedForPublication = false;
}
public E23N1(String title) {
    this();
    this.title = title;
}

public String toString() {
    if (this.approvedForPublication == false) {
        return this.title + " - pending approval";
    } else if (this.approvedForPublication == true && this.published.equals("not set")) {
        return this.title + " - to be published";
    } else if (this.approvedForPublication == true && !this.published.equals("not set")) {
        return this.title + " - " + this.published;
    } else {
        return null;
    }
}

}
