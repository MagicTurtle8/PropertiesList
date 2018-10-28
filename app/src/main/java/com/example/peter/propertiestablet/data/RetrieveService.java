package com.example.peter.propertiestablet.data;

import com.example.peter.propertiestablet.data.source.Source;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * A retrofit interface that will talk to the properties API. They return Rx Observables
 */
public interface RetrieveService {

    @GET("properties")
    Observable<Source> getProperties();

}
