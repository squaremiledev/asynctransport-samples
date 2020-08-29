# squaremile.dev - AsyncTransport Samples

```
cwd=$(pwd)
git clone git@github.com:squaremiledev/asynctransport.git
cd asynctransport
./gradlew clean build publishMavenJavaPublicationToMavenLocal -Pdev.squaremile.asynctransport.version=SNAPSHOT

cd $cwd
./gradlew clean test -Pdev.squaremile.asynctransport.version=SNAPSHOT
```