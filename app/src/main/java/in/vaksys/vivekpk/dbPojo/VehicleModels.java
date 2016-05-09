package in.vaksys.vivekpk.dbPojo;

import io.realm.RealmObject;

/**
 * Created by Harsh on 09-05-2016.
 */
public class VehicleModels extends RealmObject {

    private String vehicleId;

    private String ManufracturarName;

    private String model;

    private String modelNo;

    private String modelType;

    private String CreatedAt;

    private String UpdatedAt;

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getManufracturarName() {
        return ManufracturarName;
    }

    public void setManufracturarName(String manufracturarName) {
        ManufracturarName = manufracturarName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }
}
