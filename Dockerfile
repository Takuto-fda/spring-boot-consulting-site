# ===== ビルドステージ =====
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

# ソースコードをコピー
COPY . .

# Maven で JAR をビルド（テストはスキップ）
RUN mvn clean package -DskipTests

# ===== 実行ステージ =====
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# ビルド済みの JAR をコピー
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# ポート開放（Spring Boot のデフォルト）
EXPOSE 8080

# アプリ起動
ENTRYPOINT ["java", "-jar", "app.jar"]