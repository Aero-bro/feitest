pipeline{
    agent any
    stages{
        stage("git-clone"){
           steps{
                 script{
                                  out=sh(script:"ls feitest",returnStatus:true)
                                  println "--------------"
                                  println out
                                  if(out == 0){
                                    sh "rm -rf feitest"
                                  }
                        }
               sh "git clone https://github.com/Aero-bro/feitest.git"
           }
        }
        stage("npm-build "){
            steps{
                sh "mvn clean install"
                echo "构建完成"
            }
        }
        stage("docker-push"){
            steps{
               sh "docker -v"
               sh "docker build -t backend ."
               sh "docker login --username=慈航普渡aero --password=Zf666888? registry.cn-hangzhou.aliyuncs.com"
               sh "docker tag backend registry.cn-hangzhou.aliyuncs.com/aero_bro/fei:backend"
               sh "docker push registry.cn-hangzhou.aliyuncs.com/aero_bro/fei:backend"
               sh "docker pull registry.cn-hangzhou.aliyuncs.com/aero_bro/fei:backend && docker-compose up -d"
            }
        }
    }
}
