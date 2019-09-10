
package ObjectPageJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonData {

    @SerializedName("Login")
    @Expose
    private Login login;
    @SerializedName("ExpectedMsg")
    @Expose
    private ExpectedMsg expectedMsg;
    @SerializedName("CreateProduct")
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public ExpectedMsg getExpectedMsg() {
        return expectedMsg;
    }

    public void setExpectedMsg(ExpectedMsg expectedMsg) {
        this.expectedMsg = expectedMsg;
    }

//    public CreateProduct getCreateProduct() {
//        return createProduct;
//    }
//
//    public void setCreateProduct(CreateProduct createProduct) {
//        this.createProduct = createProduct;
//    }

}
