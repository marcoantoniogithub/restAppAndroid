package com.example.myapplication.services;

public class RetrofitService {

    private String baseUrl = "https://jsonplaceholder.typicode.com/";
    private ApiEndPoint api;
    private static RetrofitService instancia;

    private RetrofitService() {
        api = criaRetrofit().create(ApiEndPoint.class);
    }

    public static ApiEndPoint getServico() {
        if (instancia == null)
            instancia = new RetrofitService();
        return instancia.api;
    }

    private Retrofit criaRetrofit() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
    }

}
