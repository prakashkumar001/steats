package street.com.eats.interfaces;

import com.google.gson.JsonObject;

import org.json.JSONObject;

public interface ApiResult {

    public void onPreExecute();
    public void onSucess(Object object, int resultCode);
    public void onFailure(Object object, int resultCode);
}
