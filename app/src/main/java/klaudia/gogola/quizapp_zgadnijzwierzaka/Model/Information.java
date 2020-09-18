package klaudia.gogola.quizapp_zgadnijzwierzaka.Model;

public class Information {

    private int id;
    private String image, gatunek, rodzina, gromada, srodowisko, wystepowanie, trybzycia, odzywianie, ubarwienie, kategoriazagrozenia;
    private int categoryId;


    public Information(){

    }

    public Information(int id, String image, String gatunek, String rodzina, String gromada, String srodowisko, String wystepowanie, String trybzycia, String odzywianie, String ubarwienie, String kategoriazagrozenia, int categoryId) {
        this.id = id;
        this.image = image;
        this.gatunek = gatunek;
        this.rodzina = rodzina;
        this.gromada = gromada;
        this.srodowisko = srodowisko;
        this.wystepowanie = wystepowanie;
        this.trybzycia = trybzycia;
        this.odzywianie = odzywianie;
        this.ubarwienie = ubarwienie;
        this.kategoriazagrozenia = kategoriazagrozenia;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getRodzina() {
        return rodzina;
    }

    public void setRodzina(String rodzina) {
        this.rodzina = rodzina;
    }

    public String getGromada() {
        return gromada;
    }

    public void setGromada(String gromada) {
        this.gromada = gromada;
    }

    public String getSrodowisko() {
        return srodowisko;
    }

    public void setSrodowisko(String srodowisko) {
        this.srodowisko = srodowisko;
    }

    public String getWystepowanie() {
        return wystepowanie;
    }

    public void setWystepowanie(String wystepowanie) {
        this.wystepowanie = wystepowanie;
    }

    public String getTrybzycia() {
        return trybzycia;
    }

    public void setTrybzycia(String trybzycia) {
        this.trybzycia = trybzycia;
    }

    public String getOdzywianie() {
        return odzywianie;
    }

    public void setOdzywianie(String odzywianie) {
        this.odzywianie = odzywianie;
    }

    public String getUbarwienie() {
        return ubarwienie;
    }

    public void setUbarwienie(String ubarwienie) {
        this.ubarwienie = ubarwienie;
    }

    public String getKategoriazagrozenia() {
        return kategoriazagrozenia;
    }

    public void setKategoriazagrozenia(String kategoriazagrozenia) {
        this.kategoriazagrozenia = kategoriazagrozenia;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}


