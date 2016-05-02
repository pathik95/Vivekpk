package in.vaksys.vivekpk.pojo;

/**
 * Created by dell980 on 5/2/2016.
 */
public class Country {

    private String code;
    private String coutryName;

    public Country(String code, String countryName) {
        this.code = code;
        this.coutryName = countryName;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoutryName() {
        return coutryName;
    }

    public void setCoutryName(String coutryName) {
        this.coutryName = coutryName;
    }
}
