# kafka-starter
learning kafka

## Installation on MacOS
~~~~~
brew install kafka 
# bonous
brew cask install kafka-tool
~~~~~

## zookeeper ==> 
To have launchd start zookeeper now and restart at login:
~~~~~
  brew services start zookeeper
  # Or, if you don't want/need a background service you can just run:
  zkServer start
~~~~~
## kafka ==> 
To have launchd start kafka now and restart at login:
~~~~~
  brew services start kafka
  # Or, if you don't want/need a background service you can just run:
  zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties
~~~~~  