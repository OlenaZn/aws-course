package com.task02;

//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.syndicate.deployment.annotations.lambda.LambdaHandler;
//import com.syndicate.deployment.annotations.LambdaUrlConfig;
//import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
//import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
//import com.syndicate.deployment.model.lambda.url.AuthType;
//import com.syndicate.deployment.model.lambda.url.InvokeMode;
//
//import com.google.gson.Gson;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@LambdaHandler(lambdaName = "hello_world",
//	roleName = "hello_world-role",
//	isPublishVersion = true
//)
//@LambdaUrlConfig(
//	authType = AuthType.NONE,
//	invokeMode = InvokeMode.BUFFERED
//)
//public class HelloWorld implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
//
//	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//
//		return new APIGatewayProxyResponseEvent()
//			.withStatusCode(200)
//			.withBody(new gson.toJson(new HelloResponse("Hello from Lambda")));
//	}
//}

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;

import java.util.HashMap;
import java.util.Map;

@LambdaHandler(lambdaName = "hello_world",
	roleName = "hello_world-role",
	isPublishVersion = true,
	aliasName = "${lambdas_alias_name}"
)
public class HelloWorld implements RequestHandler<Object, Map<String, Object>> {

	public Map<String, Object> handleRequest(Object request, Context context) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("statusCode", 200);
		resultMap.put("message", "Hello from Lambda");

		return resultMap;
	}
}
