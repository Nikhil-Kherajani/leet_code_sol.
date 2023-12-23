<h2><a href="https://leetcode.com/problems/path-crossing/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Google</div><div class="companyTagsContainer--tagOccurence">2</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>1496. Path Crossing</a></h2><h3>Easy</h3><hr><div><p>Given a string <code>path</code>, where <code>path[i] = 'N'</code>, <code>'S'</code>, <code>'E'</code> or <code>'W'</code>, each representing moving one unit north, south, east, or west, respectively. You start at the origin <code>(0, 0)</code> on a 2D plane and walk on the path specified by <code>path</code>.</p>

<p>Return <code>true</code> <em>if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited</em>. Return <code>false</code> otherwise.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/06/10/screen-shot-2020-06-10-at-123929-pm.png" style="width: 400px; height: 358px;">
<pre><strong>Input:</strong> path = "NES"
<strong>Output:</strong> false 
<strong>Explanation:</strong> Notice that the path doesn't cross any point more than once.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/06/10/screen-shot-2020-06-10-at-123843-pm.png" style="width: 400px; height: 339px;">
<pre><strong>Input:</strong> path = "NESWW"
<strong>Output:</strong> true
<strong>Explanation:</strong> Notice that the path visits the origin twice.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= path.length &lt;= 10<sup>4</sup></code></li>
	<li><code>path[i]</code> is either <code>'N'</code>, <code>'S'</code>, <code>'E'</code>, or <code>'W'</code>.</li>
</ul>
</div>