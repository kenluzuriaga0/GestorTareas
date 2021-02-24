package entities.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 *
 * @author kenlu
 */
public class Items {

    @SerializedName("volumeInfo")
    @Expose
    VolumeInfo VolumeInfoObject;

    // Getter Methods 

    public VolumeInfo getVolumeInfoObject() {
        return VolumeInfoObject;
    }

    public void setVolumeInfoObject(VolumeInfo VolumeInfoObject) {
        this.VolumeInfoObject = VolumeInfoObject;
    }

    // Setter Methods 
    public void setVolumeInfo(VolumeInfo volumeInfoObject) {
        this.VolumeInfoObject = volumeInfoObject;
    }

}
