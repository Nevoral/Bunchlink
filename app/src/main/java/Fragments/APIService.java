package Fragments;

import Notification.MyResponse;
import Notification.Sender;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAA1lfY8E4:APA91bGedSk37o3GzVXH_bcJXzf9eyLMRETggPA2wYJ5Kf47rJv2xqgUwVOTwUZPCLiZx4iZv3UZveWi2-KjKwWTs12ngB-f5Ha-4kQUdWoeKV45zjFsMSNsAQOPHIZKna8xJnxaMdgF"
            }
    )
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
