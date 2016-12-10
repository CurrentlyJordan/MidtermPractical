package nyc.c4q.jordansmith.midtermpractical;

import nyc.c4q.jordansmith.midtermpractical.Model.Example;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jordansmith on 12/10/16.
 */

public interface VineService {

    @GET("api/timelines/users/918753190470619136")
    Call<Example> getVineResponse();

}
