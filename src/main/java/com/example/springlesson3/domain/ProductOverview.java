package com.example.springlesson3.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "overviews")
public class ProductOverview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "overview_id")
    private Long id;


    @Column(name = "overview_text")
    private String overviewText;

    @Column(name = "user_id")
    private Long CustomerId;


    @Column(name = "product_id")
    private Long productId;

    @Column(name = "rate")
    private Integer rate;

    @CreationTimestamp
    @Column(name = "added_date")
    @NonNull
    private LocalDateTime addedDate;


    @UpdateTimestamp
    @Column(name = "modify_date")
    @NonNull
    private LocalDateTime modifyDate;

    @ManyToOne
 //   @JoinColumn(name = "products", insertable = false, updatable = false)
    @JoinColumn(name = "products")
    private Product product_id;

    @ManyToOne
    @JoinColumn(name = "overviews")
    private Customer customer_id;

}
