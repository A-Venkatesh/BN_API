package com.konda.baskinnature.service.implementations;

import com.konda.baskinnature.model.*;
import com.konda.baskinnature.repository.CategoryRepository;
import com.konda.baskinnature.repository.OrderRepository;
import com.konda.baskinnature.repository.ProductRepository;
import com.konda.baskinnature.repository.RefereeRepository;
import com.konda.baskinnature.service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Locale;

import static java.lang.Integer.parseInt;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    RefereeRepository refereeRepository;

    @Autowired
    @Qualifier("javaMailSender")
    public MailService mailService;


    @Override
    public Order addOrder(Order order, String invoice) {
        Order orderRequest = orderRepository.findById(invoice).orElse(null);
        if (orderRequest == (null)) {
            orderRepository.insert(order);
            return order;
        } else return orderRequest;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(String id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid ID"));
    }

    @Override
    public List<Order> getOrdersByUser(String id) {
        return orderRepository.getOrderByUserId(id);
    }

    @Override
    public void updateStock(StockObjectList stockObjectList) {

        System.out.println((stockObjectList.getStockObjects()));
        List<StockObject> list = stockObjectList.getStockObjects();
        for (StockObject s : list) {
            Product product = productRepository.findById(s.getId()).orElseThrow(() -> new RuntimeException("invalid object"));
            Category category = categoryRepository.findById(s.getCategoryId()).orElseThrow(() -> new RuntimeException(("Invalid id ")));
            category.setSales(category.getSales() + (s.getQuantity()));
            int result = product.getStockInUnits() - (s.getQuantity());

            if (result == 0) {
                product.setStockInUnits(0);
            } else {
                product.setStockInUnits(result);
            }


            product.setTypes(product.getTypes());
            product.setPublished(product.getPublished());
            product.setPrice(product.getPrice());
            product.setImage(product.getImage());
            product.setVariants(product.getVariants());
            product.setFeatured(product.getFeatured());
            product.setDescription(product.getDescription());
            product.setTitle(product.getTitle());
            product.setGenre(product.getGenre());
            product.setSlug(product.getSlug());
            product.setCategoryId(product.getCategoryId());
            product.setId(product.getId());
            product.setRating(product.getRating());
            productRepository.save(product);
        }

    }

    @Override
    public Order setOrderStatus(String id, int code, UpdateDetails updateDetails) throws MessagingException {
        Order orderRequest = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid ID"));
        if (updateDetails.getEmail() != null) {
            switch (code) {
                case 1:
                    orderRequest.setStatus(Status.DISPACHED);
                    orderRequest.setAwb(updateDetails.getAwb());
                    orderRequest.setCourierName(updateDetails.getCourierName());
                    orderRequest.setStockObject(null);
                    mailService.sendMail("support@baskinnature.in", updateDetails.getEmail(), "Your Order # " + updateDetails.getOrderId() + " has been dispatched", "<html lang=\"en\"><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><meta name=\"description\" content=\"Order Shipping confirmation.\"><title>Bask in Nature || Shipment Notice</title><link rel=\"stylesheet\" href=\"/css/pure/pure-min.css\"><link rel=\"preconnect\" href=\"https://fonts.gstatic.com\"><link href=\"https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300;400;600&display=swap\" rel=\"stylesheet\"><style>@media (min-width: 48em){.header,.content{padding-left:2em;padding-right:2em}#layout{padding-left:150px;left:0}}@media (max-width: 48em){#layout.active{position:relative;left:150px}}</style></head><body style=\"color: #777; font-family: 'Source Sans Pro', sans-serif;\"><div id=\"layout\" style=\"position: relative; left: 0; padding-left: 0;\"><div id=\"main\"><div class=\"header\" style=\"margin: 0; color: #333; text-align: center; padding: 2.5em 2em 0; border-bottom: 1px solid #eee;\"> <img src=\"https://res.cloudinary.com/binjswi01/image/upload/v1620309187/site/LOGO_1_uclm1r.jpg\" height=\"148px\" width=\"148px\"><h3>Shipping Confirmation</h3><h5>Order # " + updateDetails.getOrderId() + " </h5></div><div class=\"content\" style=\"margin: 0 auto; padding: 0 2em; max-width: 800px; margin-bottom: 50px; line-height: 1.6em;\"><h2 class=\"content-subhead\" style=\"margin: 50px 0 20px 0; font-weight: 300; color: #888;\">Hello " + updateDetails.getName() + ",</h2><p> We thought you'd like to know that we have dispatched your item(s). Your order is on the way.</p><h2 class=\"content-subhead\" style=\"margin: 50px 0 20px 0; font-weight: 300; color: #888;\">Tracking Details</h2><p> Courier Name : " + updateDetails.getCourierName() + " </p> Air Way Bill No : " + updateDetails.getAwb() + " <p></p></div></div></div> <script src=\"/js/ui.js\"></script> </body></html>");
                    break;
                case 2:
                    orderRequest.setStatus(Status.SHIPPED);
                    break;
                default:
                    orderRequest.setStatus(Status.RECEIVED);
                    break;
            }
        } else {

            switch (code) {
                case 1:
                    orderRequest.setStatus(Status.DISPACHED);
                    orderRequest.setAwb(updateDetails.getAwb());
                    orderRequest.setCourierName(updateDetails.getCourierName());
                    orderRequest.setStockObject(null);
                    mailService.sendMail("support@baskinnature.in", "kondsaitej@gmail.com", "Your Order # " + updateDetails.getOrderId() + " has been dispatched", "<html lang=\"en\"><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><meta name=\"description\" content=\"Order Shipping confirmation.\"><title>Bask in Nature || Shipment Notice</title><link rel=\"stylesheet\" href=\"/css/pure/pure-min.css\"><link rel=\"preconnect\" href=\"https://fonts.gstatic.com\"><link href=\"https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300;400;600&display=swap\" rel=\"stylesheet\"><style>@media (min-width: 48em){.header,.content{padding-left:2em;padding-right:2em}#layout{padding-left:150px;left:0}}@media (max-width: 48em){#layout.active{position:relative;left:150px}}</style></head><body style=\"color: #777; font-family: 'Source Sans Pro', sans-serif;\"><div id=\"layout\" style=\"position: relative; left: 0; padding-left: 0;\"><div id=\"main\"><div class=\"header\" style=\"margin: 0; color: #333; text-align: center; padding: 2.5em 2em 0; border-bottom: 1px solid #eee;\"> <img src=\"https://res.cloudinary.com/binjswi01/image/upload/v1620309187/site/LOGO_1_uclm1r.jpg\" height=\"148px\" width=\"148px\"><h3>Shipping Confirmation</h3><h5>Order # " + updateDetails.getOrderId() + " </h5></div><div class=\"content\" style=\"margin: 0 auto; padding: 0 2em; max-width: 800px; margin-bottom: 50px; line-height: 1.6em;\"><h2 class=\"content-subhead\" style=\"margin: 50px 0 20px 0; font-weight: 300; color: #888;\">Hello " + updateDetails.getName() + ",</h2><p> We thought you'd like to know that we have dispatched your item(s). Your order is on the way.</p><h2 class=\"content-subhead\" style=\"margin: 50px 0 20px 0; font-weight: 300; color: #888;\">Tracking Details</h2><p> Courier Name : " + updateDetails.getCourierName() + " </p> Air Way Bill No : " + updateDetails.getAwb() + " <p></p></div></div></div> <script src=\"/js/ui.js\"></script> </body></html>");
                    break;
                case 2:
                    orderRequest.setStatus(Status.SHIPPED);
                    break;
                default:
                    orderRequest.setStatus(Status.RECEIVED);
                    break;
            }

        }
        return orderRepository.save(orderRequest);
    }

    @Override
    public Order ReleaserOrder(String id, String razorpay_payment_id) throws MessagingException {
        Order orderRequest = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid ID"));
        orderRequest.setMode("external");
        orderRequest.setRazorpay_payment_id(razorpay_payment_id);
        if (orderRequest.isCouponApplied()) {
            Referee referee = refereeRepository.findById(orderRequest.getCoupon().toUpperCase(Locale.ROOT)).orElseThrow(() -> new RuntimeException("invalid ID"));
            mailService.sendMail("support@baskinnature.in", referee.getEmail(), "Congratulations Partner", "Congrats, A purchase has been made with your coupon code " + referee.getId() + " of value ₹" + parseInt(orderRequest.getInvoice().get("amount")) / 100);
        }
        return orderRepository.save(orderRequest);
    }
}
