# AOI-Region-Matcher

# 서버 실행 방법
JDK version 11.0.13
Github에서 프로젝트를 다운받아 IntelliJ로 빌드 후 실행합니다.
데이터베이스는 Docker를 통해
docker run --name postgis -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgis/postgis
명령문 실행 후 해당 데이터베이스 사용합니다.

# API 실행 및 요청 가이드

- [POST] http://{ip address}/regions  
행정지역의 이름, 전체 지리 정보를 저장합니다.

- [POST] http://{ip address}/aois  
관심지역의 이름, 전체 지리 정보를 저장합니다.

- [GET] http://{ip address}/regions/{region-id}/aois/intersects  
행정지역에 지리적으로 포함되는 관심지역을 조회합니다.

- [Get] http://{ip address}/regions/{region_id}  
행정지역의 id를 통해서 행정지역의 id, 이름, 전체 지리 정보를 조회합니다.

- [Get] http://{ip address}/aois?lat={lat}&long={long}  
특정 좌표에 가장 가까운 관심지역을 조회합니다.
