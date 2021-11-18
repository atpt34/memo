Start docker

    docker run --name red -it -p 127.0.0.1:6379:6379/tcp redis:6.2.6
    docker ps
    docker run -it --network host --rm redis:6.2.6 redis-cli -h 127.0.0.1 -p 6379


Start app

    java -jar ... -Dserver.port=8888

Request

    curl -X PUT http://localhost:8080/abc