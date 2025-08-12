# ベースイメージ（軽量なJDK）
FROM eclipse-temurin:17-jdk-alpine

# 作業ディレクトリを作成
WORKDIR /app

# jarファイルをコンテナにコピー（名前は実際のものに合わせて）
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# ポートを開放（Spring Bootのデフォルト）
EXPOSE 8080

# アプリを起動
ENTRYPOINT ["java", "-jar", "app.jar"]
