package com.ringcentral;

import java.io.IOException;

import com.ringcentral.RestException;
import com.ringcentral.definitions.CreateSubscriptionRequest;
import com.ringcentral.definitions.NotificationDeliveryModeRequest;

public class SetupWebHook
{
    public static void main(String[] args) throws IOException, RestException
    {
        RestClient rc = new RestClient(
            System.getenv("RINGCENTRAL_CLIENT_ID"),
            System.getenv("RINGCENTRAL_CLIENT_SECRET"),
            System.getenv("RINGCENTRAL_SERVER_URL")
        );
        rc.authorize(
            System.getenv("RINGCENTRAL_USERNAME"),
            System.getenv("RINGCENTRAL_EXTENSION"),
            System.getenv("RINGCENTRAL_PASSWORD")
        );
        String WEBHOOK_ADDRESS = "https://ad0324ba.ngrok.io";
        CreateSubscriptionRequest createSubscriptionRequest = new CreateSubscriptionRequest()
            .eventFilters(new String[]{"/restapi/v1.0/account/~/extension/~/message-store/instant?type=SMS"})
            .deliveryMode(new NotificationDeliveryModeRequest().transportType("WebHook").address(WEBHOOK_ADDRESS));
        var result = rc.restapi().subscription().post(createSubscriptionRequest);
        System.out.println(result.id);
        System.out.println("WebHook Ready");
        rc.revoke();
    }
}
