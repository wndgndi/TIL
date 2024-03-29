## EBS(Elastic Block Store)란 무엇인가?

AMAZON EBS는 AWS 클라우드의 EC2 인스턴스에 사용할 영구 블록 스토리지 볼륨을 제공, 각 EBS 볼륨은 가용 영역 내에 자동으로 복제되어 구성요소 장애로부터 보호해주고 고가용성 및 내구성을 제공한다.

AMAZON EBS 볼륨은 워크로드 실행에 필요한 지연시간이 짧고 일관된 성능을 제공합니다.

AMAZON EBS를 사용하면 단 몇 분 내에 사용량을 많게 또는 적게 확장할 수 있으며, 프로비저닝한 부분에 대해서만 저렴한 비용을 지불한다.

​

흔히 EC2는 메모리, 그래픽카드 등 하드디스크를 제외한 컴퓨터의 모든 부분이라고 생각하면 된다.

EBS는 하드디스크라고 생각하면 된다.

Block Store <->File(object storage) ex: S3

Block Store = 뭔가 설치가 가능하다

Object Storage = 설치할 수 없이 파일만 저장

​

​

## EBS를 효율적으로 저장하는 방법

***Snapshot***

- 특정 시간에 EBS 상태의 저장본

    -  EBS에 사진을 찍어둔 개념

- 필요시 스냅샷을 통해 특정 시간의 EBS 복구 가능

- S3에 보관

    - 증분식 저장(변화한 부분만 저장)

​
    
​

## EC2 분류

- EBS Based: 반 영구적인 파일의 저장 기능

    - 하드 디스크와 그래픽 카드 메모리 cpu와 분리되어 네트워크로 연결

    - Instance에 비해 느리다

    - EC2를 내려도 EBS는 살아있어 다음에 또 사용이 가능하다

    - Snapshot 기능(덤프 떠서 보관 가능)

    - 인스턴스 업그레이드 기능

    - STOP이 가능하다(중요)(EC2는 세가지 state가 존재 start, stop, terminate)

​
- Instance Storage: 휘발성이 빠른 방식

    - EC2 내 물리적으로 연결되어 있다(EC2 안에 들어있음)

    - 종료시키면 EC2와 함께 날아간다

    - 빠른 연산, 굳이 저장할 필요가 없을 때 사용

    - 바로 접근하면 되니까 빠르다

    - 빠르지만 저장이 필요 없는 경우

    - Stop이 불가능하다.

​

예를들어 EBS Based인 경우 EC2가 생각보다 느릴 때 EC2와 EBS의 연결을 종료한 뒤 더 좋은 EC2를 생성해 다시 EBS와 연결한다.

​