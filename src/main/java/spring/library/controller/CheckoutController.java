package spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.request.CheckoutRequest;
import spring.library.controller.response.CheckoutListResponse;
import spring.library.sevice.CheckoutService;

@RestController
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutService checkoutService;
    @PostMapping("/checkouts/{bookId}")
    public ResponseEntity<Void> checkoutBook(@PathVariable Long bookId, @RequestBody CheckoutRequest checkoutRequest){
        checkoutService.checkoutBook(bookId, checkoutRequest.getMemberId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/checkouts")
    public ResponseEntity<CheckoutListResponse> getCheckouts(@RequestParam Long memberId){
        return ResponseEntity.ok(new CheckoutListResponse(checkoutService.getCheckouts(memberId)));
    }
}