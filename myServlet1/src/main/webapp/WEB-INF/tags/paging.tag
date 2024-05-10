<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "c" %>

<%@ attribute name="pageInfo"  type="com.yedam.common.pageDTO" required="true" %>

<div class="center">
  <div class="pagination">
  
  <a href="#">&laquo;</a>
  <a href="main.do?page=1">1</a>
  <a href="main.do?page=2" class="active">2</a>
  <a href="main.do?page=3">3</a>
  <a href="main.do?page=4">4</a>
  <a href="main.do?page=5">5</a>
  <a href="main.do?page=6">6</a>
  <a href="#">&raquo;</a>
  </div>
</div>