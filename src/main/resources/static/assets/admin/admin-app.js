app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/product", {
            templateUrl: "/assets/admin/product/index.html",
            controller: "product-ctrl"
        })
        .when("/authorize", {
            templateUrl: "/assets/admin/authority/index.html",
            controller: "authority-ctrl"
        })
        .when("/unauthorized", {
            templateUrl: "/assets/admin/authority/unauthorized.html",
            controller: "authority-ctrl"
        })
        .otherwise({
            template: "<main class='pt-4'><img src='/assets/images/apple-icon.png' alt='Logo' width='auto' height='163' class='rounded mx-auto d-block'> <h1 class='text-center text-success fw-bold pb-5'><b>A</b>dministration</h1></div>"
        });
})