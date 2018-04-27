# hello-world
my first github repo
-------------------------------------
JsonReaderExam is a NetBeans Project.

json5.json is the template used at http://www.jsonschema2pojo.org/
to generate the java classes to hold the json5.json data.

json7.json is the json that was served up by my server.
It was intended to model my understanding of the input document that could be provided.

My bit of confusion was I am use to thinking of a json document as an item of consumption,
not an array of json documents.

So I constructed the json document to contain an array of json documents - with
extra items beyond what was stated the input document would contain.

In my example the json input contains json key:value pairs and and array of json documents,
each of which contains extra key:value pairs and a numbers array;

To me this is 2 levels deep - yet the exam parameters said the document would only be 1 level deep.

The generated java classes from http://www.jsonschema2pojo.org/ provide the convenience of
an additionalProperties key:value field for each level of a json document.
That made it easy for me to locate all items beyond the minimal expected.

This project was the 2nd - the 1st was a java ee 8 glassfish5 version using Jersey,
along with Jackson Json support. It was a jax-rs/jersey/jackson/glassfish 5/java EE 8 runtime.

The inclusion of commons-lang3-3.1.jar was optionally selected at the http://www.jsonschema2pojo.org/
for the generation of equals, hashCode, and toString methods - which could have been unselected.

programRunOutput.txt is an example run with all stdout.

The program's arg[0] should be the string url of the rest endpoint.

Program compiled and run on jdk1.8.0_152 .

A complete zip of the netBeans project including executables is also provided.

