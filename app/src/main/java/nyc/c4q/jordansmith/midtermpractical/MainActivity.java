package nyc.c4q.jordansmith.midtermpractical;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import nyc.c4q.jordansmith.midtermpractical.Model.Example;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private String baseURl = "https://vine.co/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadVineData();
    }

    private void downloadVineData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vine.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VineService service = retrofit.create(VineService.class);

        Call<Example> vineCall = service.getVineResponse();
        vineCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                String jsonResponseString = response.body().toString();
                Log.d("Response",jsonResponseString);
                Log.d(TAG, "There was a success" + response);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d(TAG, "There was a failure" + t);
            }
        });


    }


}
