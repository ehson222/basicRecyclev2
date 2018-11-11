package Model;


/*
when you add a new TextView in list_row.xml, you make the field in here and required methods.
then you add int in MyAdapter class also.
You then add in public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {.
Finally you have to add in OnCreate method in MainActivity class.
 */
public class ListItem {
    private String name;
    private String description;
    private String rating;

    public ListItem(String name, String description, String rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
