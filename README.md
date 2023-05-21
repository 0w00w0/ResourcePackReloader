# ResourcePackReloader

리소스팩을 서버 재부팅 없이 변경할 수 있게 해주는 플러그인   
   
테스트된 버전: 1.19.2   
  
[다운로드](https://github.com/0w00w0/ResourcePackReloader/releases)

## 주의!
server.properties에서 리소스팩을 설정하면 ``/setdefaultresourcepack`` 명령어가 정상적으로 작동하지 않음   
``plugins/ResourcePackReloader/config.yml``에서 리소스팩을 설정해줘야 함   

## 명령어

```
/packreload <target> [<url|default>] [<sha1|none>] [<force>] [<prompt message>]
```
리소스팩을 업데이트하는 명령어   
* target: 리소스팩을 업데이트할 대상 플레이어
* url: 리소스팩 다운로드 링크   
  * default: 현재 기본으로 설정된 리소스팩(서버에 설정된 리소스팩이나 마지막으로 setdefaultresourcepack로 설정한 리소스팩)(기본값)
* sha1: 리소스팩의 sha1해쉬
  * none: 모르면 이거로 하기(기본값)
* force: 리소스팩 강제적용(플레이어가 적용을 거부하면 킥당함)
  * true: 강제로 설정하게 함(기본값)
  * false: 적용을 거부할 수 있음
* prompt message: 리소스팩 적용시에 화면에 띄울 메시지
  * 플레이어가 이미 리소스팩을 허용한적이 있으면 표시되지 않음
   
예문   
* ``/packreload @s http://localhost/resourcepack_v3.zip``
* ``/packreload @a http://localhost/resourcepack.zip none true``
* ``/packreload 0w0____ http://localhost/resourcepack_v2.zip 595347c656718f97a0d86d0d8ac0febf151393e7 true pleaseapplyresourcepack!``
***
```
/setdefaultresourcepack <url|default> [<sha1|none>] [<force>] [<prompt message>]
```
서버 접속시에 적용할 리소스팩을 설정하는 명령어   
서버를 재시작하면 설정이 사라짐   
* url: 리소스팩 다운로드 링크   
  * default: 현재 기본으로 설정된 리소스팩(서버에 설정된 리소스팩이나 마지막으로 setdefaultresourcepack로 설정한 리소스팩)(기본값)
* sha1: 리소스팩의 sha1해쉬
  * none: 모르면 이거로 하기(기본값)
* force: 리소스팩 강제적용(플레이어가 적용을 거부하면 킥당함)
  * true: 강제로 설정하게 함(기본값)
  * false: 적용을 거부할 수 있음
* prompt message: 리소스팩 적용시에 화면에 띄울 메시지
  * 플레이어가 이미 리소스팩을 허용한적이 있으면 표시되지 않음
   
예문   
* ``/setdefaultresourcepack http://localhost/resourcepack_v3.zip``
* ``/setdefaultresourcepack http://localhost/resourcepack.zip none true``
* ``/setdefaultresourcepack http://localhost/resourcepack_v2.zip 595347c656718f97a0d86d0d8ac0febf151393e7 true pleaseapplyresourcepack!``
***
```
/packstatus
```
현재 설정되어있는 서버 리소스팩의 정보를 보여주는 명령어
