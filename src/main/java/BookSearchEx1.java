import org.galapagos.domain.kakao.BookResult;
import retrofit2.Call;
import retrofit2.Response;
import service.KakaoBookService;

import java.io.IOException;

public class BookSearchEx1 {
    public static void main(String[] args) {

        KakaoBookService api = KakaoBookService.getService();

        try{

            Call<BookResult> call = api.searchBook("축구", 50, 1);//요청할 수 있는 Call 객체 리턴
            System.out.println(call.request());//요청 URL 확인
            System.out.println(call.request().headers());//헤더확인 - 인증키

            Response<BookResult> res = call.execute();//서버에 요청 전송
            if(res.isSuccessful()){
                BookResult result = res.body();//JSON을 BookResult로 역직렬화
                System.out.println(result);
            }else{
                System.out.println("호출 실패");
                System.out.println(res); // 실패시 응답 객체 출력
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
