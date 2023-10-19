import org.galapagos.domain.naver.LocalResult;
import retrofit2.Call;
import retrofit2.Response;
import service.NaverLocalSearch;

import java.io.IOException;

public class LocalSearchEx1 {
    public static void main(String[] args) {
        NaverLocalSearch api = NaverLocalSearch.getService();

        try {
            Call<LocalResult> call = api.searchLocal("강남", 5, 2);
            System.out.println(call.request());
            System.out.println(call.request().headers());

            Response<LocalResult> res = call.execute();
            if (res.isSuccessful()) {
                LocalResult result = res.body();
                System.out.println(result);
            } else {
                System.out.println("호출 실패");
                System.out.println(res);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
