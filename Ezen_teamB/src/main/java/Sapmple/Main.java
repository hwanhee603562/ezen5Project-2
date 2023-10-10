package Sapmple;
import java.util.ArrayList;
import java.util.List;



class SampleCityDto {
    private String cityName;
    private double latitude;
    private double longitude;

    public SampleCityDto(String cityName, double latitude, double longitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }
    
    public String getCityName() {
        return cityName;
    }
}

public class Main {
    public static void main(String[] args) {
        List<SampleCityDto> cityMap = new ArrayList<>();
        // 위 도시 정보들을 cityMap에 추가하는 코드
        
        cityMap.add(new SampleCityDto("서울", 37.5665, 126.9780));
        cityMap.add(new SampleCityDto("부산", 35.1796, 129.0756));
        cityMap.add(new SampleCityDto("인천", 37.4563, 126.7052));
        cityMap.add(new SampleCityDto("대구", 35.8714, 128.6014));
        cityMap.add(new SampleCityDto("대전", 36.3504, 127.3845));
        cityMap.add(new SampleCityDto("광주", 35.1595, 126.8526));
        cityMap.add(new SampleCityDto("울산", 35.5384, 129.3114));
        cityMap.add(new SampleCityDto("성남", 37.4185, 127.5183));
        cityMap.add(new SampleCityDto("수원", 37.2636, 127.0286));
        cityMap.add(new SampleCityDto("창원", 35.2272, 128.6811));
        cityMap.add(new SampleCityDto("고양", 37.6586, 126.8327));
        cityMap.add(new SampleCityDto("용인", 37.2411, 127.1775));
        cityMap.add(new SampleCityDto("안산", 37.3188, 126.8369));
        cityMap.add(new SampleCityDto("평택", 36.9949, 127.0879));
        cityMap.add(new SampleCityDto("부천", 37.5035, 126.7664));
        cityMap.add(new SampleCityDto("은평", 37.6024, 126.9292));
        cityMap.add(new SampleCityDto("남양주", 37.6363, 127.2165));
        cityMap.add(new SampleCityDto("화성", 37.1995, 126.8312));
        cityMap.add(new SampleCityDto("안양", 37.3945, 126.9578));
        cityMap.add(new SampleCityDto("장안", 37.6520, 127.0730));
        cityMap.add(new SampleCityDto("광명", 37.4781, 126.8663));
        cityMap.add(new SampleCityDto("김포", 37.6153, 126.7158));
        cityMap.add(new SampleCityDto("진주", 35.1796, 128.0780));
        cityMap.add(new SampleCityDto("진해", 35.1495, 128.6592));
        cityMap.add(new SampleCityDto("안동", 36.5662, 128.7292));
        cityMap.add(new SampleCityDto("구미", 36.1195, 128.3446));
        cityMap.add(new SampleCityDto("거제", 34.8807, 128.6144));
        cityMap.add(new SampleCityDto("양산", 35.3381, 129.0264));
        cityMap.add(new SampleCityDto("군산", 35.9743, 126.7321));
        cityMap.add(new SampleCityDto("여수", 34.7604, 127.6622));
        cityMap.add(new SampleCityDto("경주", 35.8562, 129.2242));
        cityMap.add(new SampleCityDto("익산", 35.9511, 126.9574));
        cityMap.add(new SampleCityDto("정읍", 35.5694, 126.8506));
        cityMap.add(new SampleCityDto("함양", 35.5209, 127.7257));
        cityMap.add(new SampleCityDto("김천", 36.1394, 128.1123));
        cityMap.add(new SampleCityDto("목포", 34.8121, 126.3957));
        cityMap.add(new SampleCityDto("포항", 36.0187, 129.3435));
        cityMap.add(new SampleCityDto("창녕", 35.5449, 128.5006));
        cityMap.add(new SampleCityDto("강릉", 37.7519, 128.8760));
        cityMap.add(new SampleCityDto("김해", 35.2272, 128.8810));
        cityMap.add(new SampleCityDto("곡성", 35.2762, 127.2887));
        cityMap.add(new SampleCityDto("삼척", 37.4455, 129.1680));
        cityMap.add(new SampleCityDto("통영", 34.8588, 128.4259));
        cityMap.add(new SampleCityDto("사천", 35.0030, 128.2893));
        cityMap.add(new SampleCityDto("경산", 35.8235, 128.7376));
        cityMap.add(new SampleCityDto("영주", 36.8056, 128.6235));
        cityMap.add(new SampleCityDto("상주", 36.4163, 128.1532));
        cityMap.add(new SampleCityDto("전주", 35.8242, 127.1480));
        cityMap.add(new SampleCityDto("완주", 35.9162, 127.1168));
        cityMap.add(new SampleCityDto("부안", 35.7336, 126.7217));
        cityMap.add(new SampleCityDto("나주", 35.0159, 126.7106));
        cityMap.add(new SampleCityDto("고흥", 34.6111, 127.2755));
        cityMap.add(new SampleCityDto("순천", 34.9506, 127.4875));
        cityMap.add(new SampleCityDto("담양", 35.3188, 126.9893));
        cityMap.add(new SampleCityDto("해남", 34.5730, 126.5987));
        cityMap.add(new SampleCityDto("무안", 34.9932, 126.4849));
        cityMap.add(new SampleCityDto("영암", 34.8048, 126.6902));
        cityMap.add(new SampleCityDto("구례", 35.1989, 127.4822));
        cityMap.add(new SampleCityDto("순창", 35.3740, 127.1416));
        cityMap.add(new SampleCityDto("화순", 35.0541, 127.0283));
        cityMap.add(new SampleCityDto("장성", 35.2992, 126.7851));
        cityMap.add(new SampleCityDto("강진", 34.6328, 126.7708));
        cityMap.add(new SampleCityDto("장흥", 34.6874, 126.9196));
        cityMap.add(new SampleCityDto("완도", 34.3119, 126.7383));
        cityMap.add(new SampleCityDto("진도", 34.4797, 126.2700));
        cityMap.add(new SampleCityDto("거창", 35.6866, 127.9117));
        cityMap.add(new SampleCityDto("합천", 35.5668, 128.1665));
        cityMap.add(new SampleCityDto("속초", 38.2503, 128.5647));
        cityMap.add(new SampleCityDto("양양", 38.0584, 128.6192));
        cityMap.add(new SampleCityDto("세종", 36.4801, 127.2892));
        cityMap.add(new SampleCityDto("서산", 36.7841, 126.4503));
        cityMap.add(new SampleCityDto("충주", 36.9705, 127.9308));
        cityMap.add(new SampleCityDto("청주", 36.6355, 127.4892));
        cityMap.add(new SampleCityDto("여주", 37.2958, 127.6375));
        cityMap.add(new SampleCityDto("이천", 37.2794, 127.4422));
        cityMap.add(new SampleCityDto("안성", 37.0071, 127.2817));
        cityMap.add(new SampleCityDto("제천", 37.1332, 128.2127));
        cityMap.add(new SampleCityDto("원주", 37.3496, 127.9205));
        cityMap.add(new SampleCityDto("태백", 37.1645, 128.9866));
        cityMap.add(new SampleCityDto("평창", 37.3705, 128.3927));
        cityMap.add(new SampleCityDto("정선", 37.3797, 128.6809));
        cityMap.add(new SampleCityDto("춘천", 37.8821, 127.7356));
        cityMap.add(new SampleCityDto("홍천", 37.6917, 127.8983));
        cityMap.add(new SampleCityDto("인제", 38.0654, 128.1694));
        cityMap.add(new SampleCityDto("양구", 38.1059, 127.9897));
        cityMap.add(new SampleCityDto("화천", 38.1052, 127.7125));
        cityMap.add(new SampleCityDto("파주", 37.7598, 126.7883));
        cityMap.add(new SampleCityDto("동두천", 37.9031, 127.0609));
        cityMap.add(new SampleCityDto("포천", 37.8964, 127.2003));
        cityMap.add(new SampleCityDto("철원", 38.1465, 127.3048));
        cityMap.add(new SampleCityDto("울진", 36.9912, 129.4126));
        cityMap.add(new SampleCityDto("영덕", 36.5333, 129.4113));
        cityMap.add(new SampleCityDto("광양", 34.9407, 127.6962));
        cityMap.add(new SampleCityDto("제주", 33.4996, 126.5312));
        cityMap.add(new SampleCityDto("당진", 36.9057, 126.6769));
        cityMap.add(new SampleCityDto("태안", 36.6238, 126.2997));
        cityMap.add(new SampleCityDto("청양", 36.4582, 126.7925));
        cityMap.add(new SampleCityDto("홍성", 36.6017, 126.6725));
        cityMap.add(new SampleCityDto("보령", 36.3491, 126.5783));
        cityMap.add(new SampleCityDto("공주", 36.4558, 127.1212));
        cityMap.add(new SampleCityDto("부여", 36.2729, 126.9126));
        cityMap.add(new SampleCityDto("아산", 36.7917, 127.0023));
        cityMap.add(new SampleCityDto("천안", 36.8151, 127.1134));
        cityMap.add(new SampleCityDto("문경", 36.6415, 128.1935));
        cityMap.add(new SampleCityDto("단양", 36.9832, 128.3696));
        cityMap.add(new SampleCityDto("봉화", 36.8896, 128.7412));
        cityMap.add(new SampleCityDto("영양", 36.6684, 129.1151));
        cityMap.add(new SampleCityDto("의성", 36.3554, 128.6994));
        cityMap.add(new SampleCityDto("영천", 35.9771, 128.9469));
        cityMap.add(new SampleCityDto("군위", 36.2396, 128.5729));
        cityMap.add(new SampleCityDto("강화", 37.7451, 126.5006));
        cityMap.add(new SampleCityDto("고성", 34.9765, 128.3230));
        
        String[] addresses = {
                "서울 중구 태평로1가 31",
                "인천 남동구 구월동 1138",
                "부산 연제구 연산동 1000",
                "대구 중구 동인동1가 2-1",
                "대전 서구 둔산동 1420",
                "울산 남구 신정동 646-4",
                "경기 수원시 팔달구 인계동 1111",
                "경기 여주시 금사면 금사리 산 30",
                "광주 서구 치평동 1200",
                "경남 창원시 성산구 용호동 500-6",
                "경기 용인시 처인구 삼가동 556",
                "경기 고양시 덕양구 주교동 598-1",
                "경기 안산시 단원구 고잔동 569",
                "경기 평택시 비전동 633-18",
                "경기 부천시 중동 1156",
                "서울 은평구 녹번동 84",
                "경기 남양주시 금곡동 202-7",
                "경기 안양시 동안구 관양동 1590",
                "경기 화성시 남양읍 남양리 2000",
                "서울 노원구 중계동 585",
                "경기 광명시 철산동 234",
                "경북 안동시 서부동 81-10",
                "경기 김포시 사우동 263-1",
                "경남 진주시 망경동 산 29-3",
                "경남 창원시 진해구 대천동 3",
                "경북 구미시 송정동 50",
                "경남 거제시 고현동 산 65-2",
                "전북 군산시 조촌동 780-2",
                "전남 여수시 학동 100",
                "경남 양산시 중부동 704",
                "전북 익산시 남중동 33-16",
                "경북 경주시 동천동 837",
                "전북 정읍시 수성동 524-19",
                "경남 함양군 함양읍 운림리 27-1",
                "경북 김천시 신음동 산 109-1",
                "전남 목포시 용당동 841-7",
                "경북 포항시 남구 대잠동 1001",
                "경남 창녕군 창녕읍 교리 188-2",
                "경남 김해시 봉황동 26-5",
                "전남 곡성군 곡성읍 죽동리 39-15",
                "강원특별자치도 강릉시 홍제동 1001",
                "강원특별자치도 삼척시 남양동 320",
                "경남 통영시 무전동 1027-11",
                "경남 고성군 대가면 연지리 14-9",
                "경북 경산시 중방동 880-6",
                "전북 전주시 완산구 서노송동 568-1",
                "경북 영주시 휴천동 470",
                "전북 완주군 삼례읍 신탁리 653",
                "경북 상주시 서문동 145-14",
                "전북 부안군 행안면 역리 1155",
                "전남 나주시 송월동 1100",
                "전남 순천시 장천동 53-1",
                "전남 고흥군 고흥읍 성촌리 4",
                "전남 해남군 해남읍 성내리 4",
                "전남 담양군 담양읍 지침리 179",
                "전남 무안군 무안읍 성동리 647-2",
                "전남 영암군 영암읍 망호리 717-2",
                "전남 구례군 문척면 월전리 1548-2",
                "전남 화순군 동면 서성리 산 52",
                "전북 순창군 순창읍 순화리 193",
                "전남 장성군 장성읍 영천리 1001",
                "전남 강진군 강진읍 평동리 340",
                "전남 진도군 진도읍 동외리 1189",
                "전남 장흥군 장흥읍 관덕리 247-7",
                "강원특별자치도 고성군 토성면 봉포리 111-3",
                "전남 완도군 완도읍 군내리 1154",
                "경남 거창군 거창읍 중앙리 283-3",
                "경남 합천군 합천읍 합천리 337",
                "세종특별자치시 보람동 718",
                "강원특별자치도 양양군 양양읍 월리 산 29-38",
                "충남 서산시 읍내동 492",
                "충북 충주시 성서동 450",
                "충북 청주시 상당구 북문로1가 89-2",
                "경기 여주시 홍문동 81-1",
                "경기 이천시 중리동 181-11",
                "경기 안성시 가사동 산 49-8",
                "충북 제천시 남천동 1344",
                "강원특별자치도 원주시 단계동 산 56-7",
                "강원특별자치도 태백시 황지동 244-3",
                "강원특별자치도 평창군 평창읍 하리 90-1",
                "강원특별자치도 춘천시 교동 169",
                "강원특별자치도 정선군 정선읍 애산리 산 161",
                "강원특별자치도 홍천군 홍천읍 갈마곡리 200",
                "강원특별자치도 양구군 양구읍 상리 268-15",
                "경기 파주시 아동동 산 44-6",
                "강원특별자치도 화천군 화천읍 아리 산 64-5",
                "경기 동두천시 생연동 438",
                "강원특별자치도 철원군 갈말읍 지포리 85",
                "경북 영덕군 영해면 성내리 262",
                "경기 포천시 신읍동 50-1",
                "제주특별자치도 제주시 이도이동 1176-1",
                "전남 광양시 중동 1313",
                "경북 울진군 울진읍 연지리 143-17",
                "충남 당진시 시곡동 40-2",
                "충남 홍성군 홍성읍 대교리 634",
                "충남 보령시 내항동 968-5",
                "충남 청양군 청양읍 학당리 607-4",
                "충남 부여군 부여읍 동남리 268-2",
                "충남 공주시 반죽동 15-3",
                "충남 천안시 서북구 불당동 234-1",
                "충북 단양군 단양읍 도전리 603",
                "충남 아산시 온천동 1225",
                "경북 문경시 창동 607",
                "경북 봉화군 봉화읍 내성리 279-2",
                "경북 영양군 영양읍 동부리 522-15",
                "경북 의성군 의성읍 중리리 720",
                "경북 영천시 야사동 393-8",
                "인천 강화군 강화읍 갑곳리 57",
                "대구 군위군 군위읍 동부리 169-11",
                "경남 고성군 고성읍 서외리 13-18"
            };
        System.out.println(addresses.length);
        System.out.println(cityMap.size());
        
        // 위 도시들의 위도 정보만 출력
        for ( int i=0; i<cityMap.size(); i++ ) {
            System.out.println( "insert into emediation(ename, eadress, elat, elng) values('GS25', \'"+ addresses[i] +"\', \'"+ cityMap.get(i).getLatitude() +"\' , \'"+cityMap.get(i).getLongitude()+"\' );" );
        }
    }
}