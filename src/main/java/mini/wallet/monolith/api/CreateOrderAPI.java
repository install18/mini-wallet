package mini.wallet.monolith.api;


import lombok.AllArgsConstructor;
import mini.wallet.monolith.controller.CreateOrderController;
import mini.wallet.monolith.model.request.CreateOrderRequest;
import mini.wallet.monolith.model.response.CreateOrderResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/order/create")
public class CreateOrderAPI {
    private CreateOrderController createOrderController;

    @PostMapping
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        return createOrderController.createOrder(createOrderRequest);
    }
}
