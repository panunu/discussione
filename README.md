# Discussione processing tool

## Installation

1. Run ```sbt``` on project root to get the dependencies and build the project
2. Run ```eclipse``` in sbt to bootstrap the project to be used with Scala IDE
This needs to be run every time dependencies are updated. Use ```eclipse with-source=true``` if you want to be able to browse the source of the dependencies
3. To ensure correct character encoding when crunching the data, add the following environment variable: JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8

## Running the application

1. Ensure that RabbitMQ Server is up and running
2. Ensure that MongoDB is started
