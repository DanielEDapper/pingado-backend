package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.UserSubscriptionRequest;
import io.github.danieledapper.pingado.dto.UserSubscriptionResponse;
import io.github.danieledapper.pingado.entity.UserSubscription;

public class UserSubscriptionMapper {

    private UserSubscriptionMapper() {
    }

    public static UserSubscription toEntity(
            UserSubscriptionRequest request
    ) {
        UserSubscription subscription = new UserSubscription();

        subscription.setStartDate(request.startDate());
        subscription.setEndDate(request.endDate());
        subscription.setStatus(request.status());

        return subscription;
    }

    public static UserSubscriptionResponse toResponse(
            UserSubscription subscription
    ) {
        return new UserSubscriptionResponse(
                subscription.getId(),
                subscription.getStartDate(),
                subscription.getEndDate(),
                subscription.getStatus(),
                subscription.getUser().getId(),
                subscription.getSubscriptionPlan().getId()
        );
    }
}