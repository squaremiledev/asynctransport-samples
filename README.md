# squaremile.dev - AsyncTransport Samples


## How to use AsyncTcp

See [AsyncTcp code samples](asynctcpsamples/src/test/java/dev/squaremile/asynctransportsamples/asynctcpsamples/SamplesForAsyncTcpTest.java)


```
cwd=$(pwd)
git clone git@github.com:squaremiledev/asynctransport.git
cd asynctransport
./gradlew clean build publishMavenJavaPublicationToMavenLocal -Pdev.squaremile.asynctransport.version=SNAPSHOT

cd $cwd
./gradlew clean test -Pdev.squaremile.asynctransport.version=SNAPSHOT
```